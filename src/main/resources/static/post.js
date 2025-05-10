async function postComment(pokemonNumber, content) {
    const comment = { pokemonNumber, comment: content };

    try {
        const response = await fetch('https://randompokemon-comments-production.up.railway.app//api/comments', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(comment),
        });

        if (response.ok) {
            await loadComments(pokemonNumber);  // ✅ 댓글 작성 후 바로 불러오기
        } else {
            alert('댓글 저장 실패');
        }
    } catch (error) {
        console.error('댓글 저장 중 에러:', error);
    }
}

// 폼 제출 시 호출되는 함수
document.getElementById('postForm').addEventListener('submit', function (e) {
    e.preventDefault();

    const contentInput = document.getElementById('content');
    const content = document.getElementById('content').value;
    const pokemonNumber = document.getElementById('pokemon-info').dataset.pokemonNumber;

    if (content && pokemonNumber) {
        postComment(pokemonNumber, content);
    } else {
        alert('댓글 내용과 포켓몬 번호가 필요합니다.');
    }

    contentInput.value = '';
});