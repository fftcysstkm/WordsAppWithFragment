# Words App

This folder contains the source code for the Words app codelab.

# Introduction

Words app allows you to select a letter and use Intents to navigate to an Activity that presents a
number of words starting with that letter. Each word can be looked up via a web search.

Words app contains a scrollable list of 26 letters A to Z in a RecyclerView. The orientation of the
RecyclerView can be changed between a vertical list or a grid of items.

The app demonstrates the use of Intents in two ways:

* to navigate inside an app by specifying an explicit destination, and,
* allowing Android to service the Intent using the apps and resources present on the device.

# Pre-requisites

* Experience with Kotlin syntax.
* Able to create an Activity.
* Able to create a RecyclerView and supply it with data.

# Getting Started

1. Install Android Studio, if you don't already have it.
2. Download the sample.
3. Import the sample into Android Studio.
4. Build and run the sample.

# フラグメントメモ

- アクティビティのように、各種ライフサイクル、コールバックメソッドを持つ
- レイアウトファイルをフラグメントクラスでインフレートする
    - アクティビティはonCreate()でレイアウトをインフレート、ビューをバインドする。しかし、フラグメントは2つ目のメソッド`onCreateView()`
      で行う。その後、`onViewCreated()`
      でプロパティを特定のビューにバインドする[詳細](https://developer.android.com/codelabs/basic-android-kotlin-training-fragments-navigation-component?hl=ja&continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-3-pathway-2%3Fhl%3Dja%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-fragments-navigation-component#2)。
    - バインディングクラスはnull許容型とし、nullで初期化する。フラグメントはonCrete()でライフサイクル開始がされるが、レイアウトのインフレートは次のonViewCreated()
      で行われる。

```kotlin
private var _binding: FragmentLetterListBinding? = null
private val binding get() = _binding!!

override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {
    _binding = FragmentLetterListBinding.inflate(inflater, container, false)
    val view = binding.root
    return view
}
```

-

メニューバーの使い方はアクティビティと異なるので[詳細](https://developer.android.com/codelabs/basic-android-kotlin-training-fragments-navigation-component?hl=ja&continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-3-pathway-2%3Fhl%3Dja%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-fragments-navigation-component#4)参照

# ナビゲーショングラフ

- 画面（デスティネーション）の遷移先をマッピングしたもの（ナビゲーションエディター上の画面遷移図）。各デスティネーションがどう関連しているかはXMLで表現される。
- `NavHostFragment` が画面遷移の制御役（フラグメントの切り替え）。

# Safe Args プラグイン

アクティビティ間でデータを渡すintentではputExtraでデータを渡した。 フラグメント間でデータを渡すときはSafeArgs（型安全性を助けるGradleプラグイン）を利用する
[導入方法](https://developer.android.com/codelabs/basic-android-kotlin-training-fragments-navigation-component?hl=ja&continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-3-pathway-2%3Fhl%3Dja%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-fragments-navigation-component#6)