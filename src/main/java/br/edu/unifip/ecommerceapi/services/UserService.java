package br.edu.unifip.ecommerceapi.services;


import br.edu.unifip.ecommerceapi.dtos.UserDto;
import br.edu.unifip.ecommerceapi.models.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);

    List<User> findAll();

    User create(UserDto obj);

    User update(UserDto obj);

    void delete(Integer id);
}