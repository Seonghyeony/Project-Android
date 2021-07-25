package com.seonghyeon.android.audiorecorder

/**
 * 상태를 미리 지정하는 이유는 녹음 버튼의 아이콘이 상태에 따라서 다르게 보여져야 한다.
 * 상태 값에 따라서 다른 UI를 보여줘야 하기 때문에 미리 지정.
 */
enum class State {
    BEFORE_RECORDING,
    ON_RECORDING,
    AFTER_RECORDING,
    ON_PLAYING
}