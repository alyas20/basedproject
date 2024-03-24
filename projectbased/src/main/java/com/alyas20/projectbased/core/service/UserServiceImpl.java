package com.alyas20.projectbased.core.service;

import com.alyas20.projectbased.core.security.bean.UserBean;
import com.alyas20.projectbased.core.security.entity.User;
import com.alyas20.projectbased.core.mapper.UserMapper;
import com.alyas20.projectbased.core.repository.UserRepository;
import com.alyas20.projectbased.core.security.exception.EncryptErrorException;
import com.alyas20.projectbased.core.security.securityUtil.encryption.AES256Encryption;
import com.alyas20.projectbased.core.security.securityUtil.generator.SaltKeyGenerator;
import com.alyas20.projectbased.core.security.service.TranslatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final TranslatorService translatorService;
    private final LocaleService localeService;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, TranslatorService translatorService, LocaleService localeService ) {
        this.userRepository = userRepository;
        this.translatorService = translatorService;
        this.localeService = localeService;
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
        user.setLocale(localeService.getLocaleByCode(userBean.getLocaleString()));
        userRepository.save(user);

        messageReponse = translatorService.toLocale("signup.completed");
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
