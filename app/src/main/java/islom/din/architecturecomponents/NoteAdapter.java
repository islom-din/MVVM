package islom.din.architecturecomponents;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder>{
    private List<Note> notes = new ArrayList<>();

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new NoteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder noteHolder, int position) {
        Note currentNote = notes.get(position);
        noteHolder.textViewPriority.setText(String.valueOf(currentNote.getPriority()));
        noteHolder.textViewTitle.setText(currentNote.getTitle());
        noteHolder.textViewDescription.setText(currentNote.getDescription());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    class NoteHolder extends RecyclerView.ViewHolder {
        TextView textViewPriority;
        TextView textViewTitle;
        TextView textViewDescription;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            this.textViewPriority = itemView.findViewById(R.id.textViewPriority);
            this.textViewTitle = itemView.findViewById(R.id.textViewTitle);
            this.textViewDescription = itemView.findViewById(R.id.textViewDescription);
        }
    }
}
