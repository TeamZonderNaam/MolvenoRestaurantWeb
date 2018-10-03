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

//    @PostConstruct
//    public void addSomeItemsToGetStarted() {
//
//        for(int i = 1; i < 6; i++) {
//            MenuItem item = new MenuItem();
//            item.setCategory("Food");
//            menuItemRepository.save(item);
//        }
//        MenuItem item1 = this.read(1);
//        item1.setName("Fresh Meat Dumpling");
//        item1.setPrice(3.5);
//        item1.setNumber(1);
//        menuItemRepository.save(item1);
//
//        MenuItem item2 = this.read(2);
//        item2.setName("Fried Wonton");
//        item2.setPrice(4);
//        item2.setNumber(2);
//        menuItemRepository.save(item2);
//
//        MenuItem item3 = this.read(3);
//        item3.setName("Beancurd Soup");
//        item3.setPrice(4);
//        item3.setNumber(2);
//        menuItemRepository.save(item3);
//
//        MenuItem item4 = this.read(4);
//        item4.setName("Peking Duck");
//        item4.setPrice(4);
//        item4.setNumber(2);
//        menuItemRepository.save(item4);
//
//        MenuItem item5 = this.read(5);
//        item5.setName("Hot Plate");
//        item5.setPrice(4);
//        item5.setNumber(2);
//        menuItemRepository.save(item5);

//        this.read(1).setName("Fresh Meat Dumpling");
//        this.read(2).setName("Fried Wonton");
//        this.read(3).setName("Beancurd Soup");
//        this.read(4).setName("Peking Duck");
//        this.read(5).setName("Hot Plate");
//        this.read(1).setPrice(3.5);
//        this.read(2).setPrice(4);
//        this.read(3).setPrice(4.5);
//        this.read(4).setPrice(14.5);
//        this.read(5).setPrice(21.5);
//        this.read(1).setNumber(1);
//        this.read(2).setNumber(2);
//        this.read(3).setNumber(15);
//        this.read(4).setNumber(23);
//        this.read(5).setNumber(45);

//        for(int i = 41; i < 43; i++) {
//            MenuItem item = this.read(i);
//            menuItemRepository.save(item);
//        }
//    }

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
