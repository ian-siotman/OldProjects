package com.siotman.wos.jaxws2rest.domain.dto;

import com.thomsonreuters.wokmws.v3.woksearchlite.RetrieveParameters;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RetrieveParameterDto {
    private String SID;
    private String queryId;
    private RetrieveParameters retrieveParameters;
}
