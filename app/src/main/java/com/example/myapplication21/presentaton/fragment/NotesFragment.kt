package com.example.myapplication21.presentaton.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication21.R
import com.example.myapplication21.data.Note
import com.example.myapplication21.presentaton.adapter.NotesAdapter
import com.example.myapplication21.presentaton.contract.NotesFragmentContract
import com.example.myapplication21.presentaton.presenter.NotesFragmentPresenter
import com.example.myapplication21.presentaton.recycler.OnNoteItemClickListener
import kotlinx.android.synthetic.main.fragment_notes.*

class NotesFragment: BaseFragment(), NotesFragmentContract.View, OnNoteItemClickListener {
    var arrayListOfNotes: ArrayList<Note> = ArrayList()
    var notesAdapter: NotesAdapter? = null
    lateinit var notesFragmentPresenter: NotesFragmentPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_notes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
        initializeListeners()
        initializePresenter()
        initializeLayoutManager()
        initializeAdapter()
        notesFragmentPresenter.initializeData()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.FAB_fragment_notes_goToForm -> {
                baseTransaction(R.id.relativeLayout_activity_notes_fragmentContainer,NoteFormFragment(), "AddNewNote")
            }
        }
    }

    override fun initializeViews() {
        recyclerView_fragment_notes_list?.visibility = View.VISIBLE
        initiateUpdateAdapter()
    }

    override fun initializePresenter() {
        notesFragmentPresenter = NotesFragmentPresenter()
        notesFragmentPresenter.attach(this)
    }

    override fun initializeLayoutManager() {
        recyclerView_fragment_notes_list?.layoutManager = LinearLayoutManager(context)
    }

    override fun initializeAdapter() {
        notesAdapter = NotesAdapter(context, arrayListOfNotes, this)

        recyclerView_fragment_notes_list?.adapter = notesAdapter
    }

    override fun processData(notes: ArrayList<Note>) {
        this.arrayListOfNotes.clear()
        this.arrayListOfNotes.addAll(notes)
    }

    override fun initializeListeners() {
        FAB_fragment_notes_goToForm.setOnClickListener(this)
    }

    override fun initiateUpdateAdapter() {
        notesAdapter?.notifyDataSetChanged()
    }

    override fun onNoteItemClick(item: Note, adapterPosition: Int) {

    }
}