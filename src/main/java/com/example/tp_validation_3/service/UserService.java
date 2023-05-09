package com.example.tp_validation_3.service;
import com.example.tp_validation_3.entity.Contact;
import com.example.tp_validation_3.entity.User;
import com.example.tp_validation_3.repository.ContactRepository;
import com.example.tp_validation_3.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.aspectj.asm.internal.CharOperation.indexOf;

@Service @AllArgsConstructor
@Transactional
public class UserService implements IntUserService {
    private final UserRepository userRepository;
    private final ContactRepository contactRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
    @Override
    public void updateUser(User user) {
        Optional<User> optUser = userRepository.findById(user.getId());
        if(optUser.isEmpty()){
            throw new RuntimeException("User with id: "+ user.getId()+" Not found !");
        }
        userRepository.save(optUser.get());
    }
    @Override
    public List<Contact> findAllContacts(Long userId) {
        User user = findById(userId);
        return user.getContacts();
    }
    @Override
    public User findById(Long id) {
        Optional<User> optUser = userRepository.findById(id);
        if(userRepository.findById(id).isEmpty()){
            throw new RuntimeException("User with id: "+id+" not found !");
        }
        return optUser.get();
    }
    @Override
    public Contact findContactByName(Long userId, String name) {
        List<Contact> contacts = findAllContacts(userId);
        return contacts
                .stream()
                .filter(contact -> contact.getLastName().equalsIgnoreCase(name))
                .findFirst()
                .get();
    }
    @Override
    public void addContactForUser(Long id, Contact contact) {

        User user = findById(id);
        contact.setUser(user);
        contactRepository.save(contact);
        user.getContacts().add(contact);
        userRepository.save(user);

    }
    @Override
    public void updateContactOfUser(Long idUser, Contact contact) {

        User user = findById(idUser);
        List<Contact> contacts = findAllContacts(idUser);
        Optional<Contact> toUpdate = contacts
                .stream()
                .filter(contact1 -> contact1.getId().equals(contact.getId()))
                .findFirst();
        if(toUpdate.isEmpty()){
            throw new RuntimeException("contact to update not found !");
        }
        int index = contacts.indexOf(toUpdate.get());
        contacts.set(index,contact);
        user.setContacts(contacts);
        contact.setUser(user);
        contactRepository.save(contact);
        userRepository.save(user);
    }

    @Override
    public void deleteContactFromUser(Long id, Long idContact) {
        User user = findById(id);
        List<Contact> contacts = user.getContacts();
        Optional<Contact> toDelete = contacts
                .stream()
                .filter(contact1 -> contact1.getId().equals(idContact))
                .findFirst();
        if(toDelete.isEmpty()){
            throw new RuntimeException("contact to delete not found !");
        }
        contacts.remove(toDelete.get());
        contactRepository.delete(toDelete.get());
        user.setContacts(contacts);
        userRepository.save(user);

    }
}
