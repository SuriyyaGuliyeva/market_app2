package com.project.market_app.service.impl;

import com.project.market_app.dto.AddUserDto;
import com.project.market_app.dto.UpdateUserDto;
import com.project.market_app.dto.UserInfoDto;
import com.project.market_app.exception.PasswordMismatchException;
import com.project.market_app.model.User;
import com.project.market_app.repository.UserRepository;
import com.project.market_app.service.inter.UserService;
import com.project.market_app.utils.PasswordHasher;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordHasher passwordHasher;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordHasher passwordHasher) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordHasher = passwordHasher;
    }

    @Override
    public List<UserInfoDto> userList() {
        List<User> users = userRepository.findAll();
        List<UserInfoDto> userDtos = users.stream()
                .map(user -> modelMapper.map(user, UserInfoDto.class)).collect(Collectors.toList());

        return userDtos;
    }

    @Override
    public UserInfoDto userInfo(Long id) {
        User user = userRepository.userInfo(id);
        String hashedPassword = passwordHasher.hash(user.getPassword());
        user.setPassword(hashedPassword);
        UserInfoDto userInfoDto = modelMapper.map(user, UserInfoDto.class);

        return userInfoDto;
    }

    @Override
    public void addUser(AddUserDto userDto) {
        User user = modelMapper.map(userDto, User.class);

        String hashedPassword = passwordHasher.hash(user.getPassword());
        String confirmHashedPassword = passwordHasher.hash(user.getConfirmPassword());

        user.setPassword(hashedPassword);
        user.setConfirmPassword(confirmHashedPassword);

        if (user.getPassword().isBlank() || !user.getPassword().equals(user.getConfirmPassword()))
            throw new PasswordMismatchException(
                    String.format("User email with: %s password mismatch", user.getEmail()));

        userRepository.save(user);
    }

    @Override
    public void updateUser(UpdateUserDto userDto) {
        User oldUser = userRepository.findById(userDto.getId()).get();

        String hashedPassword = passwordHasher.hash(userDto.getPassword());
        String confirmHashedPassword = passwordHasher.hash(userDto.getConfirmPassword());
        userDto.setPassword(hashedPassword);
        userDto.setConfirmPassword(confirmHashedPassword);

        oldUser.setName(userDto.getName());
        oldUser.setEmail(userDto.getEmail());
        oldUser.setPassword(hashedPassword);
        oldUser.setConfirmPassword(confirmHashedPassword);

        if (oldUser.getPassword().isBlank() || !oldUser.getPassword().equals(oldUser.getConfirmPassword()))
            throw new PasswordMismatchException(
                    String.format("User email with: %s password mismatch", oldUser.getEmail()));

        userRepository.save(oldUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
