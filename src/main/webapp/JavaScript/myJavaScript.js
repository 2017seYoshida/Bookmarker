function requiredCheck() {

	var flag = 0;

	// 設定開始（必須にする項目を設定してください）

	if (document.inputForm.bookmarkName.value == "") { // 入力をチェック
		flag = 1;
	} else if (document.inputForm.bookmarkUrl.value == "") { // 入力をチェック
		flag = 1;
	}

	// 設定終了

	if (flag) {
		alert('表示名、URLは必須項目です'); // 入力漏れがあれば警告ダイアログを表示
		return false; // 送信を中止
	} else {
		return true; // 送信を実行
	}

}