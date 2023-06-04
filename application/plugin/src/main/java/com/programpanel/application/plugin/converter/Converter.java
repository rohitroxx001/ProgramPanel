package com.programpanel.application.plugin.converter;

import com.programpanel.application.plugin.dto.DataTransferObject;
import com.programpanel.domain.plugin.entity.DomainEntity;

public interface Converter<DTO extends DataTransferObject, DE extends DomainEntity> {
    DTO convert(DE de);

    DE convert(DTO dto);
}
