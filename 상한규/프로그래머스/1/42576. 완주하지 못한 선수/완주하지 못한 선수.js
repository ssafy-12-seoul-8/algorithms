function solution(participant, completion) {
    var answer = '';
    
    participant.sort();
    completion.sort();
    
    for(let i = 0; i < completion.length; i++) {
        if(participant[i] != completion[i]) {
            answer = participant[i];
            break;
        }
    }
    
    if(answer == '') {
        answer = participant[participant.length - 1];
    }
    
    return answer;
}