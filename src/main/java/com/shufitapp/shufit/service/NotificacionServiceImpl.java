package com.shufitapp.shufit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.Notificacion;
import com.shufitapp.shufit.dto.NotificacionDTO;
import com.shufitapp.shufit.repository.NotificacionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificacionServiceImpl implements NotificacionService {

    private final NotificacionRepository notificacionRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<NotificacionDTO> findAll() {
        return notificacionRepo.findAll().stream().map(notificacion -> modelMapper.map(notificacion, NotificacionDTO.class)).collect(Collectors.toList());
    }

    @Override
    public NotificacionDTO findById(Integer id) {
        Notificacion notificacion = notificacionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Notificación no encontrada"));
        return modelMapper.map(notificacion, NotificacionDTO.class);
    }

    @Override
    public NotificacionDTO save(NotificacionDTO dto) {
        Notificacion notificacion = modelMapper.map(dto, Notificacion.class);
        Notificacion savedNotificacion = notificacionRepo.save(notificacion);
        return modelMapper.map(savedNotificacion, NotificacionDTO.class);
    }

    @Override
    public NotificacionDTO update(Integer id, NotificacionDTO dto) {
        Notificacion existingNotificacion = notificacionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Notificación no encontrada"));
        modelMapper.map(dto, existingNotificacion);
        Notificacion updatedNotificacion = notificacionRepo.save(existingNotificacion);
        return modelMapper.map(updatedNotificacion, NotificacionDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        notificacionRepo.deleteById(id);
    }

    @Override
    public List<NotificacionDTO> findByUserId(Integer userId) {
        return notificacionRepo.findByIdUsuarioOrderByFechaEnvioDesc(userId).stream()
                .map(notificacion -> modelMapper.map(notificacion, NotificacionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<NotificacionDTO> findByType(String type) {
        return notificacionRepo.findByTipoNotificacion(type).stream()
                .map(notificacion -> modelMapper.map(notificacion, NotificacionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<NotificacionDTO> findUnreadByUserId(Integer userId) {
        return notificacionRepo.findByLeidaFalseAndIdUsuario(userId).stream()
                .map(notificacion -> modelMapper.map(notificacion, NotificacionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public NotificacionDTO markAsRead(Integer id) {
        Notificacion notificacion = notificacionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Notificación no encontrada"));
        notificacion.setLeida(true);
        Notificacion updatedNotificacion = notificacionRepo.save(notificacion);
        return modelMapper.map(updatedNotificacion, NotificacionDTO.class);
    }
  

}
