/*
 * 이분검색(Binary search)
 * 
 * 1. 배열을 2개로 분할한다.
 * 2. x가 가운데 아이템보다 작으면 왼쪽 부분 배열, 크면 오른쪽 부분 배열에서 답을 찾는다.
 * 3. 선택한 부분 배열에 x가 있는지 결정하여 그 부분 배열을 정복한다.
 * 4. 답을 결정할 수 있을만큼 작지 않으면 재귀적으로 배열을 분할한다.
 * 5. 꼬리재귀(tail-recursion)
 * 		: 재귀 호출이 이루어진 후 아무런 연산이 이루어지지 않는 재귀
 **/

/*
int binSearch (   keytype k ,
                  keytype S[],
                  int low ,
                  int high     ){
      
       if (low > high)
             return 0;
       else {
            mid = low+ high / 2 ;
            
             if (k == S[ mid ])
                   return mid;
             else if ( k < S [mid ])
                   return binSearch( k , S , low, mid -1 ) ;
             else
					return binSearch( k , S , mid+ 1 , high ) ;                   
       }
}
*/


(function() {
	
	var arInputs = [ 10, 1, 2, 6, 8, 9, 13, 14, 8 ];
	var nTarget = 13;
	
	function binSearch(nTarget, arInputs, nLow, nHigh){
		if( nLow > nHigh ) {
			return -1;
		} else {
			var nMid = parseInt((nLow+nHigh) / 2);
			var nCurrentValue = arInputs[nMid];
			
			if(nTarget == nCurrentValue) {
				return nMid;
			} else if(nTarget < nCurrentValue) {
				return binSearch(nTarget, arInputs, nLow, nMid - 1 );
			} else {
				return binSearch(nTarget, arInputs, nMid + 1, nHigh );
			}
		}
	}
	
	
	var nResult = binSearch(nTarget, arInputs, 0, arInputs.length);
	console.log(nResult);
}());