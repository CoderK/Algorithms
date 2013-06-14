/*
 * 1. 배열을 n/2개 아이템을 가진 2개의 부분배열로 분할
 * 2. 각 부분배열을 정렬함으로써 정복. 배열이 충분히 작지 않으면 재귀 호출
 * 3. 부분배열에 대한 답들을 합병하여 하나의 정렬된 배열로 만든다.
 */

/*
void mergeSort (   int low , high,
                        keytype S []) {
      
       if (low < high) {
            mid = (low + high) / 2 ;
            
            mergeSort ( low, mid , S ) ;
            mergeSort ( mid + 1 , high , S) ;
            
            merge ( low, mid , high , S) ;
       }
}

void merge ( int low , mid, high ,
                  keytype S []  ){
      
      int i = low, j = mid + 1, k = low;
      keytype R [low...high] ;
      
       while (i <= mid && j <= high ) {
             if (S [ i] < S [ k]) {
                  R [ k] = S [ i++ ] ;
             } else {
                  R [ k] = S [ j++ ] ;
             }
            
            k ++;
       }
      
       if (i > mid){
            copy S [ j] through S [high ] to R[ k ] through R [ high] ;
       } else {
            copy S [ i] through S [mid ] to R[ k ] through R [ high] ;
       }

      move R[low] through R[high] to S[low] through S[high];
}
*/

(function(){
	
	function mergeSort(nLow, nHigh, arInputs){
		if(nLow < nHigh){
			var nMid = parseInt((nLow+nHigh) / 2, 10);
			
			mergeSort(nLow, nMid, arInputs);
			mergeSort(nMid + 1, nHigh, arInputs);
			
			merge(nLow, nMid, nHigh, arInputs);
		} 
	}
	
	function merge(nLow, nMid, nHigh, arInputs){
		var i = nLow, j = nMid + 1, k = nLow;
		var arTemps = [];
		
		while(i <= nMid && j <= nHigh) {
			if(arInputs[i] < arInputs[j]){
				arTemps[k] = arInputs[i++];
			} else {
				arTemps[k] = arInputs[j++];
			}
			k++;
		}
		
		if(i > nMid){
			for(; j <= nHigh; j++, k++ ) {
				arTemps[k] = arInputs[j];
			}
		} else {
			for(; i <= nMid; i++, k++ ) {
				arTemps[k] = arInputs[i];
			}
		}
		
		for(var l = nLow; l <= nHigh; l++){
			arInputs[l] = arTemps[l];
		}
	}
	
	var arInputs = [ 10, 1, 2, 6, 8, 9, 13, 14, 8 ];
	mergeSort(0, arInputs.length - 1, arInputs);
	console.log(arInputs);
}());
