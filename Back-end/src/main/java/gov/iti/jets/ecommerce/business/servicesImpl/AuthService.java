package gov.iti.jets.ecommerce.business.servicesImpl;

import gov.iti.jets.ecommerce.business.dtos.*;
import gov.iti.jets.ecommerce.business.mappers.AdminMapper;
import gov.iti.jets.ecommerce.business.mappers.CustomerMapper;
import gov.iti.jets.ecommerce.persistence.entities.Admin;
import gov.iti.jets.ecommerce.persistence.entities.Customer;
import gov.iti.jets.ecommerce.persistence.entities.Role;
import gov.iti.jets.ecommerce.persistence.entities.User;
import gov.iti.jets.ecommerce.persistence.repositories.AdminRepo;
import gov.iti.jets.ecommerce.persistence.repositories.CustomerRepo;
import gov.iti.jets.ecommerce.persistence.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepo userRepo;
    private final CustomerRepo customerRepo;
    private final AdminRepo adminRepo;
    private final PasswordEncoder passwordEncoder;
    private  final  JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    private  final AdminMapper adminMapper;
    private final CustomerMapper customerMapper;

    public AuthResponse register(RegisterRequest request , Role role) {
        if(userRepo.findUserByUsername(request.getUserName()).isPresent()){
            return AuthResponse.builder()
                    .message("Username already exist")
                    .status(false)
                    .code(401)
                    .object(null)
                    .build();
        }
        if (userRepo.findUserByEmail(request.getEmail()).isPresent()){
            return AuthResponse.builder()
                    .message("Email already exist")
                    .status(false)
                    .code(402)
                    .object(null)
                    .build();
        }
        Object object;
        if(role == Role.ADMIN){
            Admin user = new Admin();
            user.setUsername(request.getUserName());
            user.setEmail(request.getEmail());
            user.setPhone(request.getPhone());
            user.setRole(role);
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            adminRepo.save(user);
            var jwtToken = jwtService.generateToken(user);
            AdminResponse adminResponse = adminMapper.adminTOAdminResponse(user);
            adminResponse.setToken(jwtToken);
            object =adminResponse;

        }else {
            Customer user = new Customer();
            user.setUsername(request.getUserName());
            user.setEmail(request.getEmail());
            user.setPhone(request.getPhone());
            user.setRole(role);
            user.setIsMale(request.getIsMale());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            customerRepo.save(user);
            var jwtToken = jwtService.generateToken(user);
            CustomerResponse customerResponse = customerMapper.CustomerToCustomerResponse(user);
            customerResponse.setToken(jwtToken);
            object = customerResponse;
        }



        return AuthResponse.builder()
                .message("Registered Successfully")
                .status(true)
                .code(200)
                .object(object)
                .build();
    }

    public AuthResponse adminRegister(RegisterRequest request){
       return register(request , Role.ADMIN);
    }
    public AuthResponse customerRegister(RegisterRequest request){

        return register(request , Role.CUSTOMER);
    }

    public AuthResponse login(AuthRequest request) {
        String message ;
        boolean status = true;
        Object object;
        if(!userRepo.findUserByUsername(request.getUserName()).isPresent()){
            return AuthResponse.builder()
                    .message("Username Doesn't exist!")
                    .status(false)
                    .code(411)
                    .object(null)
                    .build();
        }
       
         authenticationManager.authenticate(
                 new UsernamePasswordAuthenticationToken(
                         request.getUserName(),
                         request.getPassword()
                 )
         );
        
      
         var user = userRepo.findUserByUsername(request.getUserName()).orElse(null);
         if (user == null ){
             message = "User Not found";
             status = false;
             object = null;
         }else if (user.getRole().equals(Role.ADMIN)){
             var jwtToken = jwtService.generateToken(user);
             AdminResponse adminResponse = adminMapper.adminTOAdminResponse((Admin)user);
             adminResponse.setToken(jwtToken);
             object = adminResponse;
             message = "Admin "+request.getUserName()+" LoggedIn Successfully";
         }else {
             var jwtToken = jwtService.generateToken(user);
             CustomerResponse customerResponse = customerMapper.CustomerToCustomerResponse(
                     customerRepo.findCustomerByUsername(request.getUserName()).orElseThrow()
             );
             customerResponse.setToken(jwtToken);
             object = customerResponse;
             message = "Customer "+request.getUserName()+" LoggedIn Successfully";

         }

        return AuthResponse.builder()
                .status(status)
                .message(message)
                .object(object)
                .build();
    }
}
