/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.wordsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.wordsapp.databinding.ActivityMainBinding

/**
 * Main Activity and entry point for the app. Displays a RecyclerView of letters.
 */
class MainActivity : AppCompatActivity() {

    // ナビゲーション アクションを実行できるオブジェクト. onCreateで設定されるためlateinit
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // nav_host_fragmentへの参照を取得してnavControllerプロパティに設定
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // アクションバーボタンが表示されるようにする（LetterListFragmentのメニューオプション)
        setupActionBarWithNavController(navController)
    }

    /**
     * XML で defaultNavHost を true に設定するとともに、このメソッドでは、「上へ」ボタンを処理可能
     */
    override fun onSupportNavigateUp(): Boolean {

        // navigateUp() 関数が失敗する可能性があるので、|| の右で親クラスのメソッドを呼んでおく。
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
