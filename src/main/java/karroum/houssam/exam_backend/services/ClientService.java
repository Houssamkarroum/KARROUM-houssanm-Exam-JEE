package karroum.houssam.exam_backend.services;

import karroum.houssam.exam_backend.dtos.ClientDTO;

import java.util.List;

public interface ClientService {
    ClientDTO saveClient(ClientDTO clientDTO);
    ClientDTO getClient(Long id);
    List<ClientDTO> listClients();
    List<ClientDTO> getAllClients();
    void deleteClient(Long id);
}
