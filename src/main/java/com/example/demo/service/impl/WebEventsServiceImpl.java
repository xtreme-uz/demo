package com.example.demo.service.impl;

import com.example.demo.entity.WebEvents;
import com.example.demo.mapper.WebEventsMapper;
import com.example.demo.repository.WebEventsRepository;
import com.example.demo.service.WebEventsService;
import com.example.demo.service.dto.WebEventsDTO;
import com.example.demo.web.rest.vm.WebEventsCreateVM;
import org.springframework.stereotype.Service;

@Service
public class WebEventsServiceImpl extends AbsServiceImpl<WebEvents, WebEventsDTO, WebEventsRepository, WebEventsMapper>
        implements WebEventsService {

    private final AccountsServiceImpl accountService;

    public WebEventsServiceImpl(WebEventsRepository repository, WebEventsMapper mapper, AccountsServiceImpl accountService) {
        super(repository, mapper);
        this.accountService = accountService;
    }

    @Override
    public WebEventsDTO create(WebEventsCreateVM vm){
        WebEventsDTO dto = new WebEventsDTO();
        dto.setAccount(accountService.get(vm.getAccount()));
        dto.setDate(vm.getDate());
        dto.setChannel(vm.getChannel());
        return create(dto);
    }
}
