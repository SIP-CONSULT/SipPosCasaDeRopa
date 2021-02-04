package net.sipconsult.sipposcasaderopa.ui.products

import net.sipconsult.sipposcasaderopa.data.models.LoggedInUser

class AuthResult(
    val success: LoggedInUser? = null,
    val error: Int? = null
)
