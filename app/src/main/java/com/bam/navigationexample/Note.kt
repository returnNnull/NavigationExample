package com.bam.navigationexample

import java.util.Date

data class Note(var id: Int = -1, var title: String, var body: String, var date: Date = Date())