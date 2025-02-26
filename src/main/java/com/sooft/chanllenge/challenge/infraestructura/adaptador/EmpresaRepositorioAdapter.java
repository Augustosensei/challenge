package com.sooft.chanllenge.challenge.infraestructura.adaptador;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sooft.chanllenge.challenge.dominio.modelo.Empresa;
import com.sooft.chanllenge.challenge.dominio.puerto.AdherirEmpresaPuerto;
import com.sooft.chanllenge.challenge.dominio.puerto.ObtenerEmpresasAdheridasPuerto;
import com.sooft.chanllenge.challenge.infraestructura.adaptador.mapper.EmpresaMapper;
import com.sooft.chanllenge.challenge.infraestructura.persistencia.repositorio.EmpresaRepositorio;
import com.sooft.chanllenge.challenge.infraestructura.persistencia.repositorio.TransferenciaRepositorio;
import com.sooft.chanllenge.challenge.infraestructura.persistencia.repositorio.modelo.EmpresaEntity;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmpresaRepositorioAdapter implements ObtenerEmpresasAdheridasPuerto, AdherirEmpresaPuerto {

    private final EmpresaMapper empresaMapper;
    private final EmpresaRepositorio empresaRepositorio;
    private final TransferenciaRepositorio transferenciaRepository;
   

    @Override
    @Transactional
    public Empresa guardar(Empresa empresa) {
    
        EmpresaEntity empresaEntity = empresaMapper.toEntity(empresa);
        
        empresaRepositorio.save(empresaEntity);
 
        if (empresaEntity.getTransferencias() != null) {
            empresaEntity.getTransferencias().forEach(transferenciaEntity -> {
                transferenciaEntity.setEmpresa(empresaEntity);
                transferenciaRepository.save(transferenciaEntity);
            });
        }
       
        return empresaMapper.toDomain(empresaEntity);
    }


    
    @Override
    public List<Empresa> obtenerEmpresasAdheridasUltimoMes() {
        LocalDate fechaLimite = LocalDate.now().minusMonths(1);

        return empresaMapper.toDomainList(
            empresaRepositorio.findByFechaAdhesionAfter(fechaLimite)
        );
    }
}
