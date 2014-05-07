/**
 * 문자열에 포함된 문자들이 전부 유일한지를 검사하는 알고리즘을 구현하라.
 * 다른 자료구조를 사용할 수 없는 상황이라면 어떻게 하겠는가?
 */


/* 배열 이용 */
function isUniqueStringByArray(sTarget) {
    /* JavScript의 배열은 Java의 ArrayList와 유사한 성질을 가지고 있음. */
    var bChecker = [];
    var nCharCode = 0;

    for(var i = 0; i < sTarget.length; i++){
        nCharCode = sTarget[i].charCodeAt();

        if( bChecker[ nCharCode ] ){
            return false;
        }

        bChecker[ nCharCode ] = true;
    }

    return true;
}


/*
 JavaScript는 Number type을 31비트 부동소수점 값으로 처리함.
 전체 32비트 중 1비트는 Object인지 Number인지 체크.
 따라서 시프트 연산을 30까지 할 수 있음.
 30 넘어가면 값이 깨진다.

 확인하려는 문자 요소의 범위가 a-z라면.. 비트 연산으로 처리 가능.
*/
function isUniqueStringByBitwise(sTarget){
    var nChecker = 0;
    var nUniDiff = 0;

    for(var i = 0; i < sTarget.length; i++){
        nUniDiff = sTarget.charCodeAt(i) - 'a'.charCodeAt(0);

        if( nChecker & (1 << nUniDiff ) ) {
            return false;
        }

        nChecker = nChecker | ( 1 << nUniDiff );
    }

    return true;
}

