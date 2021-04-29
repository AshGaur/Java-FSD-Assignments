class ChangingReferencesForObjects{
	int var;
	public static void main(String[] args) {
		ChangingReferencesForObjects ref = new ChangingReferencesForObjects();
		ChangingReferencesForObjects otherRef = ref.func(ref);
		System.out.println(ref.var);//675
		System.out.println(otherRef.var);//865

	}

	ChangingReferencesForObjects func(ChangingReferencesForObjects temp){
		this.var = 675; //New value assigned to object being pointed by ref
		temp = new ChangingReferencesForObjects();
		temp.var = 865; // New object being pointed stores var as 865
		return temp;
	}
}