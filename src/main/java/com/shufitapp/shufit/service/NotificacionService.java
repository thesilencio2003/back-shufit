package com.shufitapp.shufit.service;

import java.util.List;

import com.shufitapp.shufit.dto.NotificacionDTO;

public interface NotificacionService {

    List<NotificacionDTO> findAll();
    NotificacionDTO findById(Integer id);
    NotificacionDTO save(NotificacionDTO dto);
    NotificacionDTO update(Integer id, NotificacionDTO dto);
    void deleteById(Integer id);
    List<NotificacionDTO> findByUserId(Integer userId);
    List<NotificacionDTO> findByType(String type);
    List<NotificacionDTO> findUnreadByUserId(Integer userId);
    NotificacionDTO markAsRead(Integer id);

}
