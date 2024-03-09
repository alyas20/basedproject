package com.alyas20.projectbased.core.service;

import com.alyas20.projectbased.core.bean.UserBean;
import com.alyas20.projectbased.core.entity.User;
import com.alyas20.projectbased.core.mapper.UserMapper;
import com.alyas20.projectbased.core.repository.UserRepository;
import com.alyas20.projectbased.core.security.exception.EncryptErrorException;
import com.alyas20.projectbased.core.util.encryption.AES256Encryption;
import com.alyas20.projectbased.core.util.generator.SaltKeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MessageSource messageSource;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, MessageSource messageSource ) {
        this.userRepository = userRepository;
        this.messageSource = messageSource;
    }

    @Override
    public UserBean signUpProcess(UserBean userBean) {
        String messageReponse = null;
        //Note: Generate SaltKey
        String saltKey = SaltKeyGenerator.generateSalt();

        //Note: Encrypt the password
        String encryptPassword = null;
        try {
            String rawPassword = userBean.getUserPassword();
            encryptPassword =AES256Encryption.encrypt(rawPassword, saltKey);
        } catch (EncryptErrorException e) {
            e.printStackTrace();
        }

        User user = new User();
        user.setUsername(userBean.getUsername());
        user.setUserPassword(encryptPassword);
        user.setUserSaltKey(saltKey);
        user.setUserEmail(userBean.getUserEmail());
        userRepository.save(user);

        messageReponse = messageSource.getMessage("signup.completed", null, null);
        UserBean responseBean = new UserBean();
        responseBean.setUsername(user.getUsername());
        responseBean.setUserId(user.getUserId());
        responseBean.setUserEmail(user.getUserEmail());
        responseBean.setMessage(messageReponse);
        return responseBean;
    }

    @Override
    public String getEmail(String userId) {
        User user  = userRepository.findById(userId).orElseGet(null);
        return user.getUserEmail();
    }

    @Override
    public UserBean getUserByUserName(String username) {
        User user = userRepository.findByUsername(username).orElseGet(null);
        UserBean userBean = new UserBean();
        if (user != null) {
            userBean = UserMapper.mapEntityToBean(user);
        }
        return userBean;
    }
}
