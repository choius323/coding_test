"""

1213번 - 팰린드롬 만들기

팰린드롬이 가능한 문자를 정렬하면 짝수번째 자리에 출력할 문자가 나오고 파이썬의 슬라이스 기능을 사용한다.
문자열이 홀수개일 때는 홀수개인 문자만 모아서 중복을 제거해주면 된다.

"""

# s=sorted(list(input()));print("".join(s[1::2]+list(set([w for w in s if s.count(w)%2==1]))+s[-2::-2])if len([w for w in set(s)if s.count(w)%2==1])<2else"I'm Sorry Hansoo")

s = sorted(list(input()))
print("".join(s[1::2] + list(set([w for w in s if s.count(w) % 2 == 1])) + s[-2::-2])
      if len([w for w in set(s) if s.count(w) % 2 == 1]) < 2 else "I'm Sorry Hansoo")
