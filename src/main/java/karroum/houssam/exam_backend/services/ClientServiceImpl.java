package karroum.houssam.exam_backend.services;

import karroum.houssam.exam_backend.dtos.ClientDTO;
import karroum.houssam.exam_backend.entities.Client;
import karroum.houssam.exam_backend.repositories.ClientRepository;
import karroum.houssam.exam_backend.mappers.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {
        Client client = clientMapper.fromClientDTO(clientDTO);
        Client saved = clientRepository.save(client);
        return clientMapper.fromClient(saved);
    }

    @Override
    public ClientDTO getClient(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        return clientMapper.fromClient(client);
    }

    @Override
    public List<ClientDTO> listClients() {
        return clientRepository.findAll()
                .stream()
                .map(clientMapper::fromClient)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream().map(client -> {
            ClientDTO dto = new ClientDTO();
            dto.setId(client.getId());
            dto.setNom(client.getNom());
            dto.setEmail(client.getEmail());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteClient(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        clientRepository.delete(client);
    }
}
