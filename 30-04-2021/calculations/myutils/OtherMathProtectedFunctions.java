package calculations.myutils;
class OtherMathProtectedFunctions{
	protected double nthTermOfAP(double firstTerm,double commonDiff,int n){
		return firstTerm+(n-1)*commonDiff;
	}
	
	protected double sumOfNTermsAP(double firstTerm,double commonDiff,int n){
		return (n/2)*(2*firstTerm+(n-1)*commonDiff);
	}
}