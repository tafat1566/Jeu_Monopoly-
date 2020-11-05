package monopl2.Monopoly;

public class Case {
	
	public String CaseNom;
	public int CasePosition;
	public int CaseType;
	
	public Case(String caseNom, int casePosition,
			int caseType) {
		super();
		CaseNom = caseNom;
		CasePosition = casePosition;
		CaseType = caseType;
	}
	
	
	
	public int getPositionCase()
	{
		return (CasePosition);
	}
	
	
	public String getNomCase()
	{
		return (CaseNom);
	}
}
