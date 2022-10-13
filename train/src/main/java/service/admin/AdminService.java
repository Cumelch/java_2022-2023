package service.admin;

import repositories.admin.AdminRepository;

public class AdminService {
    AdminRepository adminRepository=new AdminRepository();

    public boolean signIn(String email,String password){
        return adminRepository.findUserByEmail(email,password);
    }
}
