/**
 * 문제 :
 * 문자열 2개를 입력받아 그 중 하나가 다른 하나의 순열인지 판별하는
 * 함수를 작성하라.
 */

/* 문자열을 이루는 문자 원소는 같으되, 순서만 다른 경우인지 판별 */
function isPermutation(strA, strB){
    if(strA.length != strB.length){
        return false;
    }

    /* 정렬해서 같은지 비교 */
    strA = strA.toArray().sort().join("");
    strB = strB.toArray().sort().join("");


    return strA === strB;
}
