package cinema.service.impl;

import java.util.HashSet;
import java.util.Set;

import cinema.service.AuthenticationService;
import cinema.service.RoleService;
import cinema.service.ShoppingCartService;
import cinema.service.UserService;
import cinema.model.Role;
import cinema.model.User;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final RoleService roleService;

    public AuthenticationServiceImpl(UserService userService,
                                     ShoppingCartService shoppingCartService,
                                     RoleService roleService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.roleService = roleService;
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleService.getByName(Role.RoleName.USER.toString()));
        user.setRoleSet(roleSet);
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
