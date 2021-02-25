package com.example.demo.service;

import com.example.demo.entity.WebEvents;
import com.example.demo.service.dto.WebEventsDTO;
import com.example.demo.web.rest.vm.WebEventsCreateVM;

public interface WebEventsService
        extends AbsService<WebEvents, WebEventsDTO>{

    WebEventsDTO create(WebEventsCreateVM vm);
}
