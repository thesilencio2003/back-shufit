package com.shufitapp.shufit.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.Cliente;
import com.shufitapp.shufit.Models.PlanAlimentacion;
import com.shufitapp.shufit.dto.PlanAlimentacionDTO;
import com.shufitapp.shufit.repository.ClienteRepository;
import com.shufitapp.shufit.repository.PlanAlimentacionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlanAlimentacionServiceImpl implements PlanAlimentacionService {

      private final PlanAlimentacionRepository planAlimentacionRepo;
    private final ClienteRepository clienteRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<PlanAlimentacionDTO> findAll() {
        return planAlimentacionRepo.findAll().stream()
                .map(plan -> modelMapper.map(plan, PlanAlimentacionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PlanAlimentacionDTO findById(Integer id) {
        PlanAlimentacion plan = planAlimentacionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Plan de alimentación no encontrado"));
        return modelMapper.map(plan, PlanAlimentacionDTO.class);
    }

    @Override
    public PlanAlimentacionDTO save(PlanAlimentacionDTO dto) {
        Cliente cliente = clienteRepo.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        PlanAlimentacion planAlimentacion = modelMapper.map(dto, PlanAlimentacion.class);
        planAlimentacion.setCliente(cliente);
        PlanAlimentacion savedPlan = planAlimentacionRepo.save(planAlimentacion);
        return modelMapper.map(savedPlan, PlanAlimentacionDTO.class);
    }

    @Override
    public PlanAlimentacionDTO update(Integer id, PlanAlimentacionDTO dto) {
        PlanAlimentacion existingPlan = planAlimentacionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Plan de alimentación no encontrado"));
        Cliente cliente = clienteRepo.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        modelMapper.map(dto, existingPlan);
        existingPlan.setCliente(cliente);
        PlanAlimentacion updatedPlan = planAlimentacionRepo.save(existingPlan);
        return modelMapper.map(updatedPlan, PlanAlimentacionDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        planAlimentacionRepo.deleteById(id);
    }

    @Override
    public List<PlanAlimentacionDTO> findByClienteId(Integer clienteId) {
        return planAlimentacionRepo.findByCliente_IdCliente(clienteId).stream()
                .map(plan -> modelMapper.map(plan, PlanAlimentacionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PlanAlimentacionDTO> findActivos() {
        return planAlimentacionRepo.findByFechaFinAfter(LocalDate.now()).stream()
                .map(plan -> modelMapper.map(plan, PlanAlimentacionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PlanAlimentacionDTO> findByObjetivo(String objetivo) {
        return planAlimentacionRepo.findByObjetivoIgnoreCase(objetivo).stream()
                .map(plan -> modelMapper.map(plan, PlanAlimentacionDTO.class))
                .collect(Collectors.toList());
    }

}
