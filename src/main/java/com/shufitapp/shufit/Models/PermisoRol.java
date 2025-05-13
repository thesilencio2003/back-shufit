package com.shufitapp.shufit.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "permisorol")
@Data
public class PermisoRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer idPermisoRol;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false, foreignKey = @ForeignKey(name = "FK_PERMISOROL_ROL"))
    private Rol rol;

    @Column(name = "nombre_permiso", nullable = false, length = 100)
    private String nombrePermiso;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PermisoRol)) return false;
        PermisoRol that = (PermisoRol) o;
        return rol.equals(that.rol) && nombrePermiso.equals(that.nombrePermiso);
    }

    @Override
    public int hashCode() {
        int result = rol.hashCode();
        result = 31 * result + nombrePermiso.hashCode();
        return result;
    }
}
