package factory;

public class PlanFactory {
	
	public Plan getPlan(String planType) {
		if(planType == null) {
			return null;
		}
		if(planType.equalsIgnoreCase("DOMESTIC")){
			return new DomesticPlan();
		}
		if(planType.equalsIgnoreCase("COMMERCIAL")){
			return new CommercialPlan();
		}
		if(planType.equalsIgnoreCase("INSTITUTIONAL")){
			return new InstitutionalPlan();
		}
		return null;
	}

}
