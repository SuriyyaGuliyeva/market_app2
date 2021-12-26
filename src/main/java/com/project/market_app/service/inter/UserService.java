package com.project.market_app.service.inter;

import com.project.market_app.dto.AddUserDto;
import com.project.market_app.dto.UpdateUserDto;
import com.project.market_app.dto.UserInfoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserInfoDto userInfo(Long id);

    List<UserInfoDto> userList();

    void addUser(AddUserDto userDto);

    void updateUser(UpdateUserDto userDto);

    void deleteUser(Long id);
}
