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

    @Autowired
    private CategoryService categoryService;

    public int create(MenuItem menuItem) {
        MenuItem created = this.menuItemRepository.save(menuItem);
        created.setCategory(
                categoryService.read(created.getCategory().getId())
        );
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
            if (changedItem.getMenuItemMargin() != 0) {
                oldItem.get().setMenuItemMargin(changedItem.getMenuItemMargin());
            }
            if (changedItem.getCategory() != null) {
                // If we don't get the whole object here, the program will return just the ID of the category
                int categoryId = changedItem.getCategory().getId();
                oldItem.get().setCategory(
                        categoryService.read(categoryId)
                );

            }
        }
        return menuItemRepository.save(oldItem.get());
    }

    public void delete(int id) {
        this.menuItemRepository.deleteById(id);

    }
}
