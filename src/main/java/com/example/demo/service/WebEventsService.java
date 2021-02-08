package com.example.demo.service;

import com.example.demo.entity.WebEvents;
import com.example.demo.mapper.WebEventsMapper;
import com.example.demo.repository.WebEventsRepository;
import com.example.demo.service.dto.WebEventsDTO;
import com.example.demo.web.rest.vm.WebEventsCreateVM;
import org.springframework.stereotype.Service;

@Service
public class WebEventsService extends AbsService<WebEvents, WebEventsDTO, WebEventsRepository, WebEventsMapper>{

    private final AccountsService accountService;

    public WebEventsService(WebEventsRepository repository, WebEventsMapper mapper, AccountsService accountService) {
        super(repository, mapper);
        this.accountService = accountService;
    }

    public WebEventsDTO create(WebEventsCreateVM vm){
        WebEventsDTO dto = new WebEventsDTO();
        dto.setAccount(accountService.get(vm.getAccount()));
        dto.setDate(vm.getDate());
        dto.setChannel(vm.getChannel());
        return create(dto);
    }
}
