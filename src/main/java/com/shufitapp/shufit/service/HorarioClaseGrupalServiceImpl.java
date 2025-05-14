package com.shufitapp.shufit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.ClaseGrupal;
import com.shufitapp.shufit.Models.HorarioClaseGrupal;
import com.shufitapp.shufit.dto.HorarioClaseGrupalDTO;
import com.shufitapp.shufit.repository.ClaseGrupalRepository;
import com.shufitapp.shufit.repository.HorarioClaseGrupalRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HorarioClaseGrupalServiceImpl implements HorarioClaseGrupalService {

    private final HorarioClaseGrupalRepository horarioClaseGrupalRepo;
    private final ClaseGrupalRepository claseGrupalRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<HorarioClaseGrupalDTO> findAll() {
        return horarioClaseGrupalRepo.findAll()
                .stream()
                .map(horario -> modelMapper.map(horario, HorarioClaseGrupalDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public HorarioClaseGrupalDTO findById(Integer id) {
        HorarioClaseGrupal horario = horarioClaseGrupalRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Horario de clase grupal no encontrado"));
        return modelMapper.map(horario, HorarioClaseGrupalDTO.class);
    }

@Override
public HorarioClaseGrupalDTO save(HorarioClaseGrupalDTO dto) {
    ClaseGrupal claseGrupal = claseGrupalRepo.findById(dto.getClaseId())
            .orElseThrow(() -> new RuntimeException("Clase grupal no encontrada"));
    List<HorarioClaseGrupal> horariosExistentes = horarioClaseGrupalRepo
            .findByClaseGrupal_IdClaseAndDiaSemanaAndHoraInicioAndHoraFin(
                    claseGrupal.getIdClase(), dto.getDiaSemana(), dto.getHoraInicio(), dto.getHoraFin());

    if (!horariosExistentes.isEmpty()) {
        throw new RuntimeException("Ya existe un horario similar para esta clase");
    }

    HorarioClaseGrupal horario = modelMapper.map(dto, HorarioClaseGrupal.class);
    horario.setClaseGrupal(claseGrupal);
    HorarioClaseGrupal savedHorario = horarioClaseGrupalRepo.save(horario);
    return modelMapper.map(savedHorario, HorarioClaseGrupalDTO.class);
}

@Override
public HorarioClaseGrupalDTO update(Integer id, HorarioClaseGrupalDTO dto) {
    HorarioClaseGrupal existingHorario = horarioClaseGrupalRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Horario de clase grupal no encontrado"));

    ClaseGrupal claseGrupal = claseGrupalRepo.findById(dto.getClaseId())
            .orElseThrow(() -> new RuntimeException("Clase grupal no encontrada"));

    if (!existingHorario.getClaseGrupal().getIdClase().equals(claseGrupal.getIdClase()) ||
        !existingHorario.getDiaSemana().equals(dto.getDiaSemana()) ||
        !existingHorario.getHoraInicio().equals(dto.getHoraInicio()) ||
        !existingHorario.getHoraFin().equals(dto.getHoraFin())) {
        List<HorarioClaseGrupal> horariosExistentes = horarioClaseGrupalRepo
                .findByClaseGrupal_IdClaseAndDiaSemanaAndHoraInicioAndHoraFin(
                        claseGrupal.getIdClase(), dto.getDiaSemana(), dto.getHoraInicio(), dto.getHoraFin());

        if (!horariosExistentes.isEmpty()) {
            throw new RuntimeException("Ya existe un horario similar para esta clase");
        }
    }

    modelMapper.map(dto, existingHorario);
    existingHorario.setClaseGrupal(claseGrupal);
    HorarioClaseGrupal updatedHorario = horarioClaseGrupalRepo.save(existingHorario);
    return modelMapper.map(updatedHorario, HorarioClaseGrupalDTO.class);
}

    @Override
    public void deleteById(Integer id) {
        horarioClaseGrupalRepo.deleteById(id);
    }

    @Override
    public List<HorarioClaseGrupalDTO> findByClaseId(Integer claseId) {
        return horarioClaseGrupalRepo.findByClaseGrupal_IdClase(claseId)
                .stream()
                .map(horario -> modelMapper.map(horario, HorarioClaseGrupalDTO.class))
                .collect(Collectors.toList());
    }

}
