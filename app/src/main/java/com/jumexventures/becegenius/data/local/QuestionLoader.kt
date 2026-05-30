package com.jumexventures.becegenius.data.local

import android.content.Context
import com.jumexventures.becegenius.domain.models.Question
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

class QuestionLoader(private val context: Context) {
    private val json = Json

    fun loadQuestionsBySubject(subject: String): List<Question> {
        return try {
            val fileName = subject.lowercase().replace(" ", "_") + ".json"
            val inputStream = context.assets.open("questions/$fileName")
            val jsonString = inputStream.bufferedReader().use { it.readText() }
            val jsonArray = Json.parseToJsonElement(jsonString).jsonArray

            jsonArray.map { element ->
                val obj = element.jsonObject
                Question(
                    id = obj["id"]?.jsonPrimitive?.content ?: "",
                    subject = obj["subject"]?.jsonPrimitive?.content ?: "",
                    topic = obj["topic"]?.jsonPrimitive?.content ?: "",
                    question = obj["question"]?.jsonPrimitive?.content ?: "",
                    options = obj["options"]?.jsonArray?.map { it.jsonPrimitive.content } ?: emptyList(),
                    answer = obj["answer"]?.jsonPrimitive?.content ?: "",
                    explanation = obj["explanation"]?.jsonPrimitive?.content ?: ""
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

    fun loadQuestionsByTopic(subject: String, topic: String): List<Question> {
        return loadQuestionsBySubject(subject).filter { it.topic == topic }
    }

    fun getRandomQuestion(subject: String, topic: String? = null): Question? {
        val questions = if (topic != null) {
            loadQuestionsByTopic(subject, topic)
        } else {
            loadQuestionsBySubject(subject)
        }
        return questions.randomOrNull()
    }

    fun getRandomQuestions(subject: String, count: Int, topic: String? = null): List<Question> {
        val questions = if (topic != null) {
            loadQuestionsByTopic(subject, topic)
        } else {
            loadQuestionsBySubject(subject)
        }
        return questions.shuffled().take(count)
    }
}
