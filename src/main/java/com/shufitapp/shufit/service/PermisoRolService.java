package com.shufitapp.shufit.service;

import java.util.List;

import com.shufitapp.shufit.dto.PermisoRolDTO;

public interface PermisoRolService {

    List<PermisoRolDTO> findAll();

    PermisoRolDTO findById(Integer id);

    PermisoRolDTO save(PermisoRolDTO dto);

    PermisoRolDTO update(Integer id, PermisoRolDTO dto);

    void deleteById(Integer id);

    List<PermisoRolDTO> findByRolId(Integer rolId);

    PermisoRolDTO addPermissionToRole(Integer rolId, String permissionName, String description);

    void removePermissionFromRole(Integer rolId, String permissionName);

}
