package com.capgemini.molveno.service;

import com.capgemini.molveno.model.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.molveno.repository.MenuItemRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.PostConstruct;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    public int create(MenuItem menuItem) {
        MenuItem created = this.menuItemRepository.save(menuItem);
        return created.getId();
    }

    public List<MenuItem> all(){
        Iterable<MenuItem> source = this.menuItemRepository.findAll();
        List<MenuItem> target = new ArrayList<MenuItem>();
        source.forEach(target::add);
        return target;
    }

    public MenuItem read(final int id) {
        Optional<MenuItem> item = this.menuItemRepository.findById(id);
        if (item.isPresent()) {
            return item.get();
        }
        return null;
    }

    public MenuItem update(int id, MenuItem changedItem) {
        Optional<MenuItem> oldItem = menuItemRepository.findById(id);
        if (oldItem.isPresent()) {
            if (changedItem.getName() != null) {
                oldItem.get().setName(changedItem.getName());
            }
            if (changedItem.getPrice() != 0) {
                oldItem.get().setPrice(changedItem.getPrice());
            }
            if (changedItem.getNumber() != 0) {
                oldItem.get().setNumber(changedItem.getNumber());
            }
            if (changedItem.getServings() != null) {
                oldItem.get().setServings(changedItem.getServings());
            }
            if (changedItem.getCategory() != null) {
                oldItem.get().setCategory(changedItem.getCategory());
            }
        }
        return menuItemRepository.save(oldItem.get());
    }

    public void delete(int id) {
        this.menuItemRepository.deleteById(id);

    }


}
