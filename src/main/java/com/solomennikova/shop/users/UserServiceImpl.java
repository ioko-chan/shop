package com.solomennikova.shop.users;

import com.solomennikova.shop.convert.Convert;
import com.solomennikova.shop.exception.UserExistsException;
import com.solomennikova.shop.exception.UserNotFoundException;
import com.solomennikova.shop.rest.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final Convert converter;

    @Autowired
    UserServiceImpl(UserRepository userRepository, Convert converter) {
        this.userRepository = userRepository;
        this.converter = converter;
    }

    @Override
    public void createUser(User user) throws UserExistsException {
        if (userRepository.existsByNumber(user.getNumber())) {
            throw new UserExistsException("User already exists");
        }
        userRepository.save(converter.userToUserEntity(user));
    }



    @Override
    public User getUser(Long id) {
        Optional<UserEntity> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            UserEntity userEntity = optionalUser.get();
            return converter.userEntityToUser(userEntity);
        }
        else {
            throw new UserNotFoundException("No such user exists");
        }
    }

    @Override
    public List<User> getUsers() {
        List<UserEntity> userEntityList = userRepository.findAll();
        return userEntityList.stream()
                .map(converter::userEntityToUser).collect(Collectors.toList());
    }
}
