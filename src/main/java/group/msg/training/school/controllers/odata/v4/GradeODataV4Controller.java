package group.msg.training.school.controllers.odata.v4;

import com.sap.cloud.sdk.service.prov.api.annotations.Function;
import com.sap.cloud.sdk.service.prov.api.operations.Create;
import com.sap.cloud.sdk.service.prov.api.operations.Query;
import com.sap.cloud.sdk.service.prov.api.request.CreateRequest;
import com.sap.cloud.sdk.service.prov.api.request.OperationRequest;
import com.sap.cloud.sdk.service.prov.api.request.QueryRequest;
import com.sap.cloud.sdk.service.prov.api.response.CreateResponse;
import com.sap.cloud.sdk.service.prov.api.response.OperationResponse;
import com.sap.cloud.sdk.service.prov.api.response.QueryResponse;
import group.msg.training.school.config.ODataInstanceProvider;
import group.msg.training.school.controllers.odata.base.GradeODataController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GradeODataV4Controller {
	private final GradeODataController base;

	public GradeODataV4Controller() {
		this.base = ODataInstanceProvider.getInstanceTyped(GradeODataController.class);
	}

	@Query(serviceName = "srv", entity = "Grades", sourceEntity = "Students")
	public QueryResponse getGradesOfStudent(QueryRequest request) {
		return base.getGradesOfStudent(request);
	}

	@Create(serviceName = "srv", entity = "Grades")
	public CreateResponse addGradeToStudent(CreateRequest request) {
		return base.addGradeToStudent(request);
	}

	@Function(serviceName = "srv", Name = "GetAverageGradesForGroup")
	public OperationResponse getAverageGradesPerGroup(OperationRequest request) {
		return base.getAverageGradesPerGroup(request);
	}

}
