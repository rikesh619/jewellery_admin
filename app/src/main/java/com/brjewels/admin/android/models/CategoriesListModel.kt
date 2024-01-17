package com.brjewels.admin.android.models

data class CategoriesListModel(var nestedList: List<String>, var itemText: String) {
    var isExpandable: Boolean = false
        private set

    fun setExpandableValue(expandable: Boolean) {
        isExpandable = expandable
    }
}

