package com.example.demo.service.impl;

import com.example.demo.entity.Orders;
import com.example.demo.mapper.OrdersMapper;
import com.example.demo.repository.OrdersRepository;
import com.example.demo.service.OrderService;
import com.example.demo.service.dto.OrdersDTO;
import com.example.demo.web.rest.vm.OrdersCreateVM;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Service
public class OrdersServiceImpl extends AbsServiceImpl<Orders, OrdersDTO, OrdersRepository, OrdersMapper>
        implements OrderService {

    private final AccountsServiceImpl service;

    public OrdersServiceImpl(OrdersRepository repository, OrdersMapper mapper, AccountsServiceImpl service) {
        super(repository, mapper);
        this.service = service;
    }
    @Override
    public OrdersDTO create(OrdersCreateVM vm){

        OrdersDTO dto = new OrdersDTO();
        dto.setAccounts(service.get(vm.getAccounts()));
        dto.setStandardQty(vm.getStandardQty());
        dto.setPosterQty(vm.getPosterQty());
        dto.setGlossyQty(vm.getGlossyQty());
        dto.setTotal(vm.getTotal());
        dto.setDate(vm.getDate());
        dto.setStandardAmountUsd(vm.getStandardAmountUsd());
        dto.setGlossyAmountUsd(vm.getGlossyAmountUsd());
        dto.setPosterAmountUsd(vm.getPosterAmountUsd());
        dto.setTotalAmountUsd(vm.getTotalAmountUsd());

        return create(dto);
    }

    @Override
    public OrdersDTO imgUpload(Long id, MultipartFile file){
        Optional<Orders> byId = repository.findById(id);
        if(byId.isPresent()){
            //
            Orders orders = byId.get();
            orders.setImage(saveFile(file));
            Orders save = repository.save(orders);
            return mapper.toDto(save);
        }
        throw new RuntimeException("User not found");
    }

    @Override
    public Resource load(String filePath){
        try {
            Path path = Paths.get(filePath.replace("|", "/")).normalize();
            return new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("exception while loading file");
    }

    private String saveFile(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String newFileName = System.currentTimeMillis() + fileName;
        Path filePath = Path.of("profile", "img", newFileName);
        if(!Files.exists(filePath)){
            try {
                Files.createDirectories(filePath);
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                return filePath.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        throw new RuntimeException("exception while uploading file");
    }
}