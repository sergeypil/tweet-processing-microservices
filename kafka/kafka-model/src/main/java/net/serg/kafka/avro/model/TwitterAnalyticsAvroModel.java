/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package net.serg.kafka.avro.model;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class TwitterAnalyticsAvroModel extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -5607999511825562279L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"TwitterAnalyticsAvroModel\",\"namespace\":\"net.serg.kafka.avro.model\",\"fields\":[{\"name\":\"word\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"wordCount\",\"type\":[\"null\",\"long\"]},{\"name\":\"createdAt\",\"type\":[\"null\",\"long\"],\"logicalType\":[\"null\",\"date\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<TwitterAnalyticsAvroModel> ENCODER =
      new BinaryMessageEncoder<TwitterAnalyticsAvroModel>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<TwitterAnalyticsAvroModel> DECODER =
      new BinaryMessageDecoder<TwitterAnalyticsAvroModel>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<TwitterAnalyticsAvroModel> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<TwitterAnalyticsAvroModel> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<TwitterAnalyticsAvroModel> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<TwitterAnalyticsAvroModel>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this TwitterAnalyticsAvroModel to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a TwitterAnalyticsAvroModel from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a TwitterAnalyticsAvroModel instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static TwitterAnalyticsAvroModel fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.String word;
   private java.lang.Long wordCount;
   private java.lang.Long createdAt;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public TwitterAnalyticsAvroModel() {}

  /**
   * All-args constructor.
   * @param word The new value for word
   * @param wordCount The new value for wordCount
   * @param createdAt The new value for createdAt
   */
  public TwitterAnalyticsAvroModel(java.lang.String word, java.lang.Long wordCount, java.lang.Long createdAt) {
    this.word = word;
    this.wordCount = wordCount;
    this.createdAt = createdAt;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return word;
    case 1: return wordCount;
    case 2: return createdAt;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: word = value$ != null ? value$.toString() : null; break;
    case 1: wordCount = (java.lang.Long)value$; break;
    case 2: createdAt = (java.lang.Long)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'word' field.
   * @return The value of the 'word' field.
   */
  public java.lang.String getWord() {
    return word;
  }


  /**
   * Sets the value of the 'word' field.
   * @param value the value to set.
   */
  public void setWord(java.lang.String value) {
    this.word = value;
  }

  /**
   * Gets the value of the 'wordCount' field.
   * @return The value of the 'wordCount' field.
   */
  public java.lang.Long getWordCount() {
    return wordCount;
  }


  /**
   * Sets the value of the 'wordCount' field.
   * @param value the value to set.
   */
  public void setWordCount(java.lang.Long value) {
    this.wordCount = value;
  }

  /**
   * Gets the value of the 'createdAt' field.
   * @return The value of the 'createdAt' field.
   */
  public java.lang.Long getCreatedAt() {
    return createdAt;
  }


  /**
   * Sets the value of the 'createdAt' field.
   * @param value the value to set.
   */
  public void setCreatedAt(java.lang.Long value) {
    this.createdAt = value;
  }

  /**
   * Creates a new TwitterAnalyticsAvroModel RecordBuilder.
   * @return A new TwitterAnalyticsAvroModel RecordBuilder
   */
  public static net.serg.kafka.avro.model.TwitterAnalyticsAvroModel.Builder newBuilder() {
    return new net.serg.kafka.avro.model.TwitterAnalyticsAvroModel.Builder();
  }

  /**
   * Creates a new TwitterAnalyticsAvroModel RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new TwitterAnalyticsAvroModel RecordBuilder
   */
  public static net.serg.kafka.avro.model.TwitterAnalyticsAvroModel.Builder newBuilder(net.serg.kafka.avro.model.TwitterAnalyticsAvroModel.Builder other) {
    if (other == null) {
      return new net.serg.kafka.avro.model.TwitterAnalyticsAvroModel.Builder();
    } else {
      return new net.serg.kafka.avro.model.TwitterAnalyticsAvroModel.Builder(other);
    }
  }

  /**
   * Creates a new TwitterAnalyticsAvroModel RecordBuilder by copying an existing TwitterAnalyticsAvroModel instance.
   * @param other The existing instance to copy.
   * @return A new TwitterAnalyticsAvroModel RecordBuilder
   */
  public static net.serg.kafka.avro.model.TwitterAnalyticsAvroModel.Builder newBuilder(net.serg.kafka.avro.model.TwitterAnalyticsAvroModel other) {
    if (other == null) {
      return new net.serg.kafka.avro.model.TwitterAnalyticsAvroModel.Builder();
    } else {
      return new net.serg.kafka.avro.model.TwitterAnalyticsAvroModel.Builder(other);
    }
  }

  /**
   * RecordBuilder for TwitterAnalyticsAvroModel instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<TwitterAnalyticsAvroModel>
    implements org.apache.avro.data.RecordBuilder<TwitterAnalyticsAvroModel> {

    private java.lang.String word;
    private java.lang.Long wordCount;
    private java.lang.Long createdAt;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(net.serg.kafka.avro.model.TwitterAnalyticsAvroModel.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.word)) {
        this.word = data().deepCopy(fields()[0].schema(), other.word);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.wordCount)) {
        this.wordCount = data().deepCopy(fields()[1].schema(), other.wordCount);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.createdAt)) {
        this.createdAt = data().deepCopy(fields()[2].schema(), other.createdAt);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing TwitterAnalyticsAvroModel instance
     * @param other The existing instance to copy.
     */
    private Builder(net.serg.kafka.avro.model.TwitterAnalyticsAvroModel other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.word)) {
        this.word = data().deepCopy(fields()[0].schema(), other.word);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.wordCount)) {
        this.wordCount = data().deepCopy(fields()[1].schema(), other.wordCount);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.createdAt)) {
        this.createdAt = data().deepCopy(fields()[2].schema(), other.createdAt);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'word' field.
      * @return The value.
      */
    public java.lang.String getWord() {
      return word;
    }


    /**
      * Sets the value of the 'word' field.
      * @param value The value of 'word'.
      * @return This builder.
      */
    public net.serg.kafka.avro.model.TwitterAnalyticsAvroModel.Builder setWord(java.lang.String value) {
      validate(fields()[0], value);
      this.word = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'word' field has been set.
      * @return True if the 'word' field has been set, false otherwise.
      */
    public boolean hasWord() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'word' field.
      * @return This builder.
      */
    public net.serg.kafka.avro.model.TwitterAnalyticsAvroModel.Builder clearWord() {
      word = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'wordCount' field.
      * @return The value.
      */
    public java.lang.Long getWordCount() {
      return wordCount;
    }


    /**
      * Sets the value of the 'wordCount' field.
      * @param value The value of 'wordCount'.
      * @return This builder.
      */
    public net.serg.kafka.avro.model.TwitterAnalyticsAvroModel.Builder setWordCount(java.lang.Long value) {
      validate(fields()[1], value);
      this.wordCount = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'wordCount' field has been set.
      * @return True if the 'wordCount' field has been set, false otherwise.
      */
    public boolean hasWordCount() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'wordCount' field.
      * @return This builder.
      */
    public net.serg.kafka.avro.model.TwitterAnalyticsAvroModel.Builder clearWordCount() {
      wordCount = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'createdAt' field.
      * @return The value.
      */
    public java.lang.Long getCreatedAt() {
      return createdAt;
    }


    /**
      * Sets the value of the 'createdAt' field.
      * @param value The value of 'createdAt'.
      * @return This builder.
      */
    public net.serg.kafka.avro.model.TwitterAnalyticsAvroModel.Builder setCreatedAt(java.lang.Long value) {
      validate(fields()[2], value);
      this.createdAt = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'createdAt' field has been set.
      * @return True if the 'createdAt' field has been set, false otherwise.
      */
    public boolean hasCreatedAt() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'createdAt' field.
      * @return This builder.
      */
    public net.serg.kafka.avro.model.TwitterAnalyticsAvroModel.Builder clearCreatedAt() {
      createdAt = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TwitterAnalyticsAvroModel build() {
      try {
        TwitterAnalyticsAvroModel record = new TwitterAnalyticsAvroModel();
        record.word = fieldSetFlags()[0] ? this.word : (java.lang.String) defaultValue(fields()[0]);
        record.wordCount = fieldSetFlags()[1] ? this.wordCount : (java.lang.Long) defaultValue(fields()[1]);
        record.createdAt = fieldSetFlags()[2] ? this.createdAt : (java.lang.Long) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<TwitterAnalyticsAvroModel>
    WRITER$ = (org.apache.avro.io.DatumWriter<TwitterAnalyticsAvroModel>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<TwitterAnalyticsAvroModel>
    READER$ = (org.apache.avro.io.DatumReader<TwitterAnalyticsAvroModel>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    if (this.word == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.word);
    }

    if (this.wordCount == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeLong(this.wordCount);
    }

    if (this.createdAt == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeLong(this.createdAt);
    }

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      if (in.readIndex() != 1) {
        in.readNull();
        this.word = null;
      } else {
        this.word = in.readString();
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.wordCount = null;
      } else {
        this.wordCount = in.readLong();
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.createdAt = null;
      } else {
        this.createdAt = in.readLong();
      }

    } else {
      for (int i = 0; i < 3; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          if (in.readIndex() != 1) {
            in.readNull();
            this.word = null;
          } else {
            this.word = in.readString();
          }
          break;

        case 1:
          if (in.readIndex() != 1) {
            in.readNull();
            this.wordCount = null;
          } else {
            this.wordCount = in.readLong();
          }
          break;

        case 2:
          if (in.readIndex() != 1) {
            in.readNull();
            this.createdAt = null;
          } else {
            this.createdAt = in.readLong();
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










