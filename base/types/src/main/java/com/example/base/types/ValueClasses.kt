package com.example.base.types

@JvmInline
value class Username(val value: String) {
    init {
        require(value.isNotBlank())
    }
}

@JvmInline
value class Password(val value: String) {
    init {
        require(value.isNotBlank())
    }
}
